package org.infinispan.quickstart.openshift.cache.jcache;

import javax.cache.*;
import javax.cache.configuration.*;
import javax.cache.spi.*;

public class CreateCache<cache> {

   private static final String KEY = "hello";
   private static final String VALUE = "world";

   public static void main(String[] args) {
      CacheManager cacheManager = Caching.getCachingProvider("org.infinispan.jcache.remote.JCachingProvider").getCacheManager();
      Cache<String, String> cache = cacheManager.getCache("default");

      cache.put(KEY, VALUE);

      System.out.printf("--- Retrieve key='%s' ---%n", KEY);
      final String value = cache.get(KEY);

      System.out.printf("--- Value is '%s' ---%n", value);

      assert VALUE.equals(value) : "Expected value of '" + value + "' but was: " + value;
   }

}
