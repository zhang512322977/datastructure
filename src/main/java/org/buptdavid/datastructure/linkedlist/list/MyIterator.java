package org.buptdavid.datastructure.linkedlist.list;

import java.util.Objects;

public interface MyIterator<E> {


    boolean hasNext();


    E next();

    default void remove()
    {
        throw new UnsupportedOperationException("remove");
    }


    default void forEachRemaining(MyConsumer<? super E> action)
    {
        Objects.requireNonNull(action);
        while (hasNext())
        {
            action.accept(next());
        }

    }

}
