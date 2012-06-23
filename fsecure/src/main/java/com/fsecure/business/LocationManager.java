/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.business;

import com.fsecure.base.PersistenceManagerService;
import com.fsecure.entity.LocationEntity;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

/**
 *
 * @author Dickson
 */
public class LocationManager extends Manager {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private EntityManagerFactory emf = PersistenceManagerService.getInstance().getEntityManagerFactory();

    /**
     *
     * @param float latitude
     * @param float longitude
     * @return JSONObject
     */
    public JSONObject getNearestLocation(float latitude, float longitude) {
        EntityManager em = emf.createEntityManager();
        JSONObject jsonObject = null;

        try {
            // this query is getting from: https://developers.google.com/maps/articles/phpsqlsearch#findnearsql
            Query q = em.createNativeQuery("SELECT latitude, longitude, name, is_building, "
                    + "(3959 * ACOS(COS( RADIANS(?1) ) * COS( RADIANS( latitude ) ) * COS( RADIANS( longitude ) - RADIANS(?2) ) + SIN( RADIANS(?1) ) * SIN( RADIANS( latitude)))) "
                    + "AS distance FROM location ORDER BY distance FETCH FIRST 1 ROWS ONLY", LocationEntity.class);
            q.setParameter(1, longitude);
            q.setParameter(2, latitude);

            LocationEntity locEnt = (LocationEntity) q.getSingleResult();
            jsonObject = new JSONObject();
            BigDecimal[] locationArr = {locEnt.getLocationPK().getLongitude(), locEnt.getLocationPK().getLatitude()};
            jsonObject.put("location", locationArr);
            jsonObject.put("name", locEnt.getName());
            jsonObject.put("is_building", locEnt.getIsBuilding());

        } catch (Exception ex) {
            logger.debug("Fail to getNearestLocation: " + ex.toString());

        } finally {
            em.close();
        }
        return jsonObject;
    }
}
