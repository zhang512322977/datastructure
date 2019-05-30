package org.buptdavid.datastructure.linkedlist.list;

import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;

public interface MyIterable<T> {

    MyIterator<T> myIterator();

    default void forEach(MyConsumer<? super T> action)
    {
        Objects.requireNonNull(action);
        for (T t:this) {
            action.accept(t);
        }
    }
    default MySpliterator<T> spliterator() {
        return MySpliterators.spliteratorUnknownSize(myIterator(), 0);
    }

}
