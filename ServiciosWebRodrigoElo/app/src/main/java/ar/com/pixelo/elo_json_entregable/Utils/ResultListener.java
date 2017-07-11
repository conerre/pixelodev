package ar.com.pixelo.elo_json_entregable.Utils;

public interface ResultListener<T> {
    void finish(T resultado);
}