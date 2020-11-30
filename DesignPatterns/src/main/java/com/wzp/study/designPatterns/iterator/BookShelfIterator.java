/*
 * Copyright (c) 2001-2020 melotgroup Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of melotgroup Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with http://melotgroup.com/.
 */
package com.wzp.study.designPatterns.iterator;

/**
 * TODO
 *
 * @author admin
 * @version V1.0
 * @since 2020-11-30 15:18
 */
public class BookShelfIterator implements Iterator{

    BookShelf bookShelf;

    int index = 0;

    @Override
    public boolean hashNext() {
        return index < bookShelf.list.size();
    }

    @Override
    public Book next() {
        Book book = bookShelf.list.get(index);
        index++;
        return book;
    }

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }
}
