package org.example.Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CommonCardColumnAll implements CommonObjectiveInterface {
    List<TileType> tileTypes = new List<TileType>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<TileType> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(TileType tileType) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends TileType> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends TileType> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public TileType get(int index) {
            return null;
        }

        @Override
        public TileType set(int index, TileType element) {
            return null;
        }

        @Override
        public void add(int index, TileType element) {

        }

        @Override
        public TileType remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<TileType> listIterator() {
            return null;
        }

        @Override
        public ListIterator<TileType> listIterator(int index) {
            return null;
        }

        @Override
        public List<TileType> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public boolean executeAlgorithm(String nameOfCard) {
        int counterLine = 0;
        if (nameOfCard == "Vertical different six") {
            if (counterLine == 2) { return true; }
            else { return false; }
        } else if (nameOfCard == "Row of 5 different tiles") {
            if (counterLine == 2) { return true; }
            else { return false; }
        }
        return false;}
}
