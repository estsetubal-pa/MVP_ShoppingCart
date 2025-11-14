package mvp;

import mvp.model.ShoppingCart;
import mvp.presenter.ShoppingCartPresenter;
import mvp.view.ShoppingCartView;
import mvp.view.ShoppingCartUI;

public class FactoryMVP {

    public static ShoppingCartView create(){
        ShoppingCart model = new ShoppingCart("Bruno");
        ShoppingCartUI view = new ShoppingCartUI();
        ShoppingCartPresenter presenter = new ShoppingCartPresenter(view, model);
        return view;

    }
}
