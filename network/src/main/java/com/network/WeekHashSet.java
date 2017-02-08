package com.network;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by wb-qjl256634 on 2017/2/3.
 */

public class WeekHashSet extends HashSet {
    ReferenceQueue queue = new ReferenceQueue();

    public WeekHashSet() {
    }

    public Iterator iterator() {
        this.processQueue();
        final Iterator i = super.iterator();
        return new Iterator() {
            public boolean hasNext() {
                return i.hasNext();
            }

            public Object next() {
                try {
                    return WeekHashSet.this.getReferenceObject((WeakReference)i.next());
                } catch (ClassCastException var2) {
                    return null;
                }
            }

            public void remove() {
                i.remove();
            }
        };
    }

    public boolean contains(Object o) {
        return super.contains(WeekHashSet.WeakElement.create(o));
    }

    public boolean add(Object o) {
        this.processQueue();
        return super.add(WeekHashSet.WeakElement.create(o, this.queue));
    }

    public boolean remove(Object o) {
        boolean ret = super.remove(WeekHashSet.WeakElement.create(o));
        this.processQueue();
        return ret;
    }

    private final Object getReferenceObject(WeakReference ref) {
        return ref == null?null:ref.get();
    }

    private final void processQueue() {
        WeekHashSet.WeakElement wv = null;

        while((wv = (WeekHashSet.WeakElement)this.queue.poll()) != null) {
            super.remove(wv);
        }

    }

    private static class WeakElement extends WeakReference {
        private int hash;

        private WeakElement(Object o) {
            super(o);
            this.hash = o.hashCode();
        }

        private WeakElement(Object o, ReferenceQueue q) {
            super(o, q);
            this.hash = o.hashCode();
        }

        private static WeekHashSet.WeakElement create(Object o) {
            return o == null?null:new WeekHashSet.WeakElement(o);
        }

        private static WeekHashSet.WeakElement create(Object o, ReferenceQueue q) {
            return o == null?null:new WeekHashSet.WeakElement(o, q);
        }

        public boolean equals(Object o) {
            if(this == o) {
                return true;
            } else if(!(o instanceof WeekHashSet.WeakElement)) {
                return false;
            } else {
                Object t = this.get();
                Object u = ((WeekHashSet.WeakElement)o).get();
                return t == u?true:(t != null && u != null?t.equals(u):false);
            }
        }

        public int hashCode() {
            return this.hash;
        }
    }
}
