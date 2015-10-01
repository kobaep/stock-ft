// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.psa.security;

import com.psa.security.AppUser;
import com.psa.security.AppUserDataOnDemand;
import com.psa.security.AppUserIntegrationTest;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect AppUserIntegrationTest_Roo_IntegrationTest {
    
    declare @type: AppUserIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: AppUserIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: AppUserIntegrationTest: @Transactional;
    
    @Autowired
    AppUserDataOnDemand AppUserIntegrationTest.dod;
    
    @Test
    public void AppUserIntegrationTest.testCountAppUsers() {
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", dod.getRandomAppUser());
        long count = AppUser.countAppUsers();
        Assert.assertTrue("Counter for 'AppUser' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void AppUserIntegrationTest.testFindAppUser() {
        AppUser obj = dod.getRandomAppUser();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to provide an identifier", id);
        obj = AppUser.findAppUser(id);
        Assert.assertNotNull("Find method for 'AppUser' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'AppUser' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void AppUserIntegrationTest.testFindAllAppUsers() {
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", dod.getRandomAppUser());
        long count = AppUser.countAppUsers();
        Assert.assertTrue("Too expensive to perform a find all test for 'AppUser', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<AppUser> result = AppUser.findAllAppUsers();
        Assert.assertNotNull("Find all method for 'AppUser' illegally returned null", result);
        Assert.assertTrue("Find all method for 'AppUser' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void AppUserIntegrationTest.testFindAppUserEntries() {
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", dod.getRandomAppUser());
        long count = AppUser.countAppUsers();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<AppUser> result = AppUser.findAppUserEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'AppUser' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'AppUser' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void AppUserIntegrationTest.testFlush() {
        AppUser obj = dod.getRandomAppUser();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to provide an identifier", id);
        obj = AppUser.findAppUser(id);
        Assert.assertNotNull("Find method for 'AppUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyAppUser(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'AppUser' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AppUserIntegrationTest.testMergeUpdate() {
        AppUser obj = dod.getRandomAppUser();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to provide an identifier", id);
        obj = AppUser.findAppUser(id);
        boolean modified =  dod.modifyAppUser(obj);
        Integer currentVersion = obj.getVersion();
        AppUser merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'AppUser' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void AppUserIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", dod.getRandomAppUser());
        AppUser obj = dod.getNewTransientAppUser(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'AppUser' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'AppUser' identifier to be null", obj.getId());
        try {
            obj.persist();
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'AppUser' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void AppUserIntegrationTest.testRemove() {
        AppUser obj = dod.getRandomAppUser();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'AppUser' failed to provide an identifier", id);
        obj = AppUser.findAppUser(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'AppUser' with identifier '" + id + "'", AppUser.findAppUser(id));
    }
    
}