package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {
    @Override
    public Entity create(Collection<Entity> collection, String value) {
        checkArguments(collection, value);
        int id = collection.size();
        Entity entity = new EntityImpl(id, value);
        collection.add(entity);
        return entity;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        checkArguments(collection, entity);
        for (Entity e : collection) {
            if ((e.getValue()).equals(entity.getValue())) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        checkArguments(collection, entity);
        for (Entity e : collection) {
            if (e.equals(entity)) {
                ((EntityImpl)e).setValue(value);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        checkArguments(collection, entity);
        collection.remove(entity);
    }

    private void checkArguments(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
    }
}
