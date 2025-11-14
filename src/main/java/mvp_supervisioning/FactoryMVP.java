package mvp_supervisioning;

import mvp_supervisioning.model.ShoppingCart;
import mvp_supervisioning.presenter.ShoppingCartPresenter;
import mvp_supervisioning.view.ShoppingCartUI;
import mvp_supervisioning.view.ShoppingCartView;

public class FactoryMVP {

    public static ShoppingCartView create(){
        ShoppingCart model = new ShoppingCart("Bruno");
        ShoppingCartUI view = new ShoppingCartUI(model);
        ShoppingCartPresenter presenter = new ShoppingCartPresenter(view, model);
        return view;

    }
}
