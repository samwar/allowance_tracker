package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/17/13
 * Time: 10:42 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Allowance extends Model {

    @Id
    public String id;

    @Constraints.Required
    public float allowance = 0;

    public float remainder = 0;

    public Date startDate = Calendar.getInstance().getTime();

    @Override
    public String toString() {
        return "Allowance{" +
                "allowance=" + allowance +
                ", remainder=" + remainder +
                '}';
    }
}
