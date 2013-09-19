package controllers;

import models.Allowance;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.allowance;


/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/17/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllowanceController extends Controller {

    public static Result allowance() {
        return ok(allowance.render("Enter the amount of your allowance."));
    }

    public static Result addAllowance() {
        Allowance allowance = Form.form(Allowance.class).bindFromRequest().get();

        allowance.remainder = allowance.allowance;
        allowance.save();

        return redirect(routes.AllowanceController.allowance());
    }
}
