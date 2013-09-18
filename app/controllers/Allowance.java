package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;


/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/17/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Allowance extends Controller {

    public static Result allowance() {
        return ok(allowance.render("Hello World"));
    }
}
