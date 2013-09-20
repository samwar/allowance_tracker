package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: SWARTERS
 * Date: 9/17/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Purchase extends Model {

    @Id
    public String id;

    @Constraints.Required
    public float amount;

    public String purchaseType;

    @Formats.DateTime(pattern="dd/MM/yyyy hh:mm")
    public Date purchaseDate = Calendar.getInstance().getTime();

    @ManyToOne
    @JoinColumn(name = "allowance_id")
    public Allowance allowance;

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type='" + purchaseType + '\'' +
                ", allowance=" + allowance +
                '}';
    }

}
