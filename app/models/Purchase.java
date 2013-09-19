package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    public double amount;

    public String type;

}
