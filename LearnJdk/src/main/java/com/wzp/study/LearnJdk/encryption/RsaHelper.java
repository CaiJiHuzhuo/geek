package com.melot.kk.scm.admin.server.sign;

import com.wzp.study.LearnJdk.encryption.EncryptionException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;

public class RsaHelper {
    /**
     * 生成公钥、私钥对(keysize=1024)
     *
     * @return
     */
    public KeyPairInfo getKeyPair() throws EncryptionException {
        return getKeyPair(1024);
    }

    /**
     * 生成公钥、私钥对
     *
     * @param keySize
     * @return
     */
    public KeyPairInfo getKeyPair(int keySize) throws EncryptionException {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            // 初始化密钥对生成器，密钥大小一般要大于1024位，
            keyPairGen.initialize(keySize);
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 得到私钥
            RSAPrivateKey oraprivateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 得到公钥
            RSAPublicKey orapublicKey = (RSAPublicKey) keyPair.getPublic();

            KeyPairInfo pairInfo = new KeyPairInfo(keySize);
            //公钥
            byte[] publicKeybyte = orapublicKey.getEncoded();
            String publicKeyString = Base64.encodeBase64String(publicKeybyte);
            pairInfo.setPublicKey(publicKeyString);
            //私钥
            byte[] privateKeybyte = oraprivateKey.getEncoded();
            String privateKeyString = Base64.encodeBase64String(privateKeybyte);
            pairInfo.setPrivateKey(privateKeyString);

            return pairInfo;
        } catch (Exception e) {
            throw new EncryptionException("商品推送加密生成秘钥失败", e);
        }
    }

    /**
     * 获取公钥对象
     *
     * @param publicKeyBase64
     * @return
     * @throws EncryptionException
     */
    public PublicKey getPublicKey(String publicKeyBase64) throws EncryptionException {

        PublicKey publicKey;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec publicpkcs8KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyBase64));
            publicKey = keyFactory.generatePublic(publicpkcs8KeySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new EncryptionException("商品推送加密获取公钥失败", e);
        }

    }

    /**
     * 获取私钥对象
     *
     * @param privateKeyBase64
     * @return
     * @throws EncryptionException
     */
    public PrivateKey getPrivateKey(String privateKeyBase64) throws EncryptionException {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privatekcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyBase64));
            PrivateKey privateKey = keyFactory.generatePrivate(privatekcs8KeySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new EncryptionException("商品推送加密获取私钥失败", e);
        }
    }

    /**
     * 使用共钥加密
     *
     * @param content         待加密内容
     * @param publicKeyBase64 公钥 base64 编码
     * @return 经过 base64 编码后的字符串
     */
    public String rsaEncrypt(String content, String publicKeyBase64) throws EncryptionException {
        return encipher(content, publicKeyBase64, -1);
    }

    /**
     * 使用共钥加密（分段加密）
     *
     * @param content         待加密内容
     * @param publicKeyBase64 公钥 base64 编码
     * @param segmentSize     分段大小,一般小于 keySize/8（段小于等于0时，将不使用分段加密）
     * @return 经过 base64 编码后的字符串
     */
    public String encipher(String content, String publicKeyBase64, int segmentSize) throws EncryptionException {
        try {
            PublicKey publicKey = getPublicKey(publicKeyBase64);
            return encipher(content, publicKey, segmentSize);
        } catch (Exception e) {
            throw new EncryptionException("encipher failure,EncryptContent = " + content, e);
        }
    }

    /**
     * 分段加密
     *
     * @param ciphertext  密文
     * @param key         加密秘钥
     * @param segmentSize 分段大小，<=0 不分段
     * @return
     */
    public String encipher(String ciphertext, java.security.Key key, int segmentSize)
        throws BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException,
        IOException, InvalidKeyException {
        // 用公钥加密
        byte[] srcBytes = ciphertext.getBytes();

        // Cipher负责完成加密或解密工作，基于RSA
        Cipher cipher = Cipher.getInstance("RSA");
        // 根据公钥，对Cipher对象进行初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] resultBytes = null;

        if (segmentSize > 0) {
            //分段加密
            resultBytes = cipherDoFinal(cipher, srcBytes, segmentSize);
        } else {
            resultBytes = cipher.doFinal(srcBytes);
        }

        return Base64.encodeBase64String(resultBytes);
    }

    /**
     * 分段大小
     *
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws javax.crypto.IllegalBlockSizeException
     * @throws javax.crypto.BadPaddingException
     * @throws java.io.IOException
     */
    private byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize)
        throws BadPaddingException, IllegalBlockSizeException, IOException {

        if (segmentSize <= 0) {
            throw new RuntimeException("分段大小必须大于0");
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;
    }

    /**
     * 使用私钥解密
     *
     * @param contentBase64    待加密内容,base64 编码
     * @param privateKeyBase64 私钥 base64 编码
     * @return
     * @segmentSize 分段大小
     */
    public String rsaDecrypt(String contentBase64, String privateKeyBase64) throws EncryptionException {
        return decipher(contentBase64, privateKeyBase64, -1);
    }

    /**
     * 使用私钥解密（分段解密）
     *
     * @param contentBase64    待加密内容,base64 编码
     * @param privateKeyBase64 私钥 base64 编码
     * @return
     * @segmentSize 分段大小
     */
    public String decipher(String contentBase64, String privateKeyBase64, int segmentSize) throws EncryptionException {
        try {
            PrivateKey privateKey = getPrivateKey(privateKeyBase64);
            return decipher(contentBase64, privateKey, segmentSize);
        } catch (Exception e) {
            throw new EncryptionException("decipher failure,EncryptContent = " + contentBase64, e);
        }
    }

    /**
     * 分段解密
     *
     * @param contentBase64 密文
     * @param key           解密秘钥
     * @param segmentSize   分段大小（小于等于0不分段）
     * @return
     */
    public String decipher(String contentBase64, java.security.Key key, int segmentSize) throws EncryptionException {
        try {
            // 用私钥解密
            byte[] srcBytes = Base64.decodeBase64(contentBase64);
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher deCipher = Cipher.getInstance("RSA");
            // 根据公钥，对Cipher对象进行初始化
            deCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decBytes = null;//deCipher.doFinal(srcBytes);
            if (segmentSize > 0)
                decBytes = cipherDoFinal(deCipher, srcBytes, segmentSize); //分段加密
            else
                decBytes = deCipher.doFinal(srcBytes);

            String decrytStr = new String(decBytes);
            return decrytStr;
        } catch (Exception e) {
            throw new EncryptionException("decipher failure,EncryptContent = " + contentBase64, e);
        }
    }

    /**
     * 秘钥对
     */
    public static class KeyPairInfo {
        public KeyPairInfo(int keySize) {
            setKeySize(keySize);
        }

        public KeyPairInfo(String publicKey, String privateKey) {
            setPrivateKey(privateKey);
            setPublicKey(publicKey);
        }

        String privateKey;
        String publicKey;
        int keySize = 0;

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public int getKeySize() {
            return keySize;
        }

        public void setKeySize(int keySize) {
            this.keySize = keySize;
        }
    }

}