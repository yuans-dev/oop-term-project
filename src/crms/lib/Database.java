package crms.lib;

import java.util.ArrayList;

public abstract class Database<T> {

    protected ArrayList<T> dataList;

    public abstract void saveToDisk();

    public abstract void fetchFromDisk();

    public abstract T getItemById(String id);

}
