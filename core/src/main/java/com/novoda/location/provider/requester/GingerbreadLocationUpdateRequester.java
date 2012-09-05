/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Code modified by Novoda Ltd, 2011.
 */
package com.novoda.location.provider.requester;


import android.app.PendingIntent;
import android.location.Criteria;
import android.location.LocationManager;
import com.novoda.location.LocatorSettings;

/**
 * Provides support for initiating active and passive location updates
 * optimized for the Gingerbread release. Includes use of the Passive Location Provider.
 * <p/>
 * Uses broadcast Intents to notify the app of location changes.
 */
public class GingerbreadLocationUpdateRequester extends FroyoLocationUpdateRequester {

    public GingerbreadLocationUpdateRequester(LocationManager locationManager) {
        super(locationManager);
    }

    @Override
    public void requestActiveLocationUpdates(LocatorSettings settings, Criteria criteria, PendingIntent pendingIntent) {
        long minTime = settings.getUpdatesInterval();
        float minDistance = settings.getUpdatesDistance();
        locationManager.requestLocationUpdates(minTime, minDistance, criteria, pendingIntent);
    }
}
