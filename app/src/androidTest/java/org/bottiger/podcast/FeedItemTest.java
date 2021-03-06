/*
 * Copyright (C) 2008 The Android Open Source Project
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
 */

package org.bottiger.podcast;


import android.content.ContentResolver;
import android.test.mock.MockContentResolver;

import org.bottiger.podcast.provider.FeedItem;
import org.bottiger.podcast.provider.ItemColumns;
import org.bottiger.podcast.provider.PodcastProvider;


public class FeedItemTest extends android.test.ProviderTestCase<PodcastProvider> {

	MockContentResolver context;
	
    public FeedItemTest() {
		super(PodcastProvider.class, PodcastProvider.AUTHORITY);
		// TODO Auto-generated constructor stub
	}
    

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        context  = getMockContentResolver();

    }    

    public void testStartDownload() throws Exception {
    	FeedItem item = new FeedItem();
    	item.id = 1;
    	//item.pathname = "";
    	//item.prepareDownload(context);
        //assertTrue(item.status==ItemColumns.ITEM_STATUS_DOWNLOADING_NOW);
        //assertTrue(item.getAbsolutePath().equals("/mnt/sdcard/xuluan.podcast/download/podcast_1.mp3"));
    }
    
    public void testEndDownload() throws Exception {
    	FeedItem item = new FeedItem();
    	item.id = 1;
    	//item.pathname = "";
    	item.failcount = 2;
    	item.endDownload(context);
        //assertTrue(item.status==ItemColumns.ITEM_STATUS_DOWNLOAD_QUEUE);
        //assertTrue(item.failcount==3);
    }  
    
    public void testEndDownloadPause() throws Exception {
    	FeedItem item = new FeedItem();
    	item.id = 1;
    	//item.pathname = "";
    	item.failcount = 5;
    	item.endDownload(context);
        //assertTrue(item.status==ItemColumns.ITEM_STATUS_DOWNLOAD_PAUSE);
        //assertTrue(item.failcount==0);
    }     
    
    public void testEndDownloadSuccess() throws Exception {
    	FeedItem item = new FeedItem();
    	item.id = 1;
    	//item.pathname = "";
    	item.status = ItemColumns.ITEM_STATUS_NO_PLAY;
    	long update = Long.valueOf(System.currentTimeMillis());
    	item.endDownload(context);
        //assertTrue(item.status==ItemColumns.ITEM_STATUS_NO_PLAY);
        //assertTrue(item.failcount==0);
        //assertTrue(item.offset==0);
        //assertTrue(update<=item.lastUpdate);
        //assertTrue((update+10)>item.lastUpdate);
    }
    
    

}
