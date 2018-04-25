package houseproperty.manyihe.com.myh_android.presenter;

/**
 * Created by Mr.周 on 2018/3/14.
 */

public interface IPresenter<T> {
    void attach(T view);

    void detach();
}
