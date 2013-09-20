package controllers;

import models.Allowance;
import models.Purchase;
import play.Logger;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.purchase;

import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/18/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseController extends Controller {

    public static Result purchase() {
        List<Allowance> allowances = new Model.Finder(String.class, Allowance.class).all();

        if(allowances.isEmpty()) {
            return ok(index.render("Welcome to the allowance tracker!"));
        }

        float amt = allowances.get(0).allowance;

        for(Allowance allowance : allowances) {
            Logger.debug(allowance.toString());
        }

        return ok(purchase.render(allowances.get(0), "Enter your purchase"));
    }

    public static Result addPurchase() {
        Purchase purchase = Form.form(Purchase.class).bindFromRequest().get();
        List<Allowance> allowances = new Model.Finder(String.class, Allowance.class).all();
        Allowance allowance = allowances.get(0);
        allowance.remainder -= purchase.amount;
        Logger.debug("Allowance remainder:" + allowance.remainder);
        Logger.debug (allowance.toString());
        allowance.update();
        Logger.debug(purchase.purchaseType);
        purchase.allowance = allowance;
        purchase.save();

        return redirect(routes.PurchaseController.purchase());
    }

    public static Result listPurchases() {
        return TODO;
//        List<Purchase> purchases = new Model.Finder(String.class, Purchase.class).all();

//        return ok(toJson(purchases));
//         return ok(views.html.purchases.render(purchases));
    }
}
