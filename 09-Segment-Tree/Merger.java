//融合器，用于用于自定义融合的方法（如：相加）
public interface Merger<E> {
    public E merge(E left,E right);
}
