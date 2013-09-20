package controllers;

import models.Allowance;
import play.Logger;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.allowance;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/17/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllowanceController extends Controller {

    public static Result allowance() {
        List<Allowance> allowanceList = new Model.Finder(String.class, Allowance.class).all();
        Allowance allowance = null;
        if(allowanceList.isEmpty()) {
            allowance = new Allowance();
            allowance.save();
        } else {
           allowance = allowanceList.get(0);
        }
        Logger.debug(allowance.id);
        return ok(views.html.allowance.render(allowance,"Enter the amount of your allowance"));
    }

    public static Result addAllowance() {
        Allowance allowance = Form.form(Allowance.class).bindFromRequest().get();
        Allowance oldAllowance = (Allowance) new Model.Finder(String.class, Allowance.class).byId(allowance.id);
        //Logger.debug(allowance.id);
        if(oldAllowance.remainder == 0) {
            allowance.remainder = allowance.allowance;
        } else if (allowance.allowance < oldAllowance.allowance) {
            allowance.remainder = oldAllowance.remainder - (oldAllowance.allowance - allowance.allowance);
        } else if (allowance.allowance > oldAllowance.allowance) {
            allowance.remainder = oldAllowance.remainder + (allowance.allowance - oldAllowance.allowance);
        }
        allowance.update();

        return redirect(routes.AllowanceController.allowance());
    }
}
