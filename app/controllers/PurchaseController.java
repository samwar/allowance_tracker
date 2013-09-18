package controllers;

import models.Allowance;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.purchase;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/18/13
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseController extends Controller {

    public static Result purchase() {
        List<Allowance> allowances = new Model.Finder(Double.class, Allowance.class).all();
        Double amt = allowances.get(0).allowance;
        return ok(purchase.render(allowances.get(0)));
    }

    public static Result addPurchase() {
        return ok();
    }
}
