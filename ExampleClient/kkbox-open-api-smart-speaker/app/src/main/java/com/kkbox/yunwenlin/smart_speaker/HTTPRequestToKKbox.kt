package com.kkbox.yunwenlin.smart_speaker

import android.os.AsyncTask


class HTTPRequestToKKbox: AsyncTask<String, Unit, Unit>() {

    var kkboxClient = KKboxOpenAPIClient()
    override fun doInBackground(vararg p: String) {
        kkboxClient.doSearch(p[0], p[1], p[2])
    }
}