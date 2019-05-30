package org.buptdavid.datastructure.linkedlist.list;

public interface MySpliterator<T> {


    boolean tryAdvance(MyConsumer<? super T> action);
}
