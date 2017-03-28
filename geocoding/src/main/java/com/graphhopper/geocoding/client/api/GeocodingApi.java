/**
 * GraphHopper Geocoding API
 * GraphHopper Geocoding API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.graphhopper.geocoding.client.api;

import com.graphhopper.geocoding.client.ApiCallback;
import com.graphhopper.geocoding.client.ApiClient;
import com.graphhopper.geocoding.client.ApiException;
import com.graphhopper.geocoding.client.ApiResponse;
import com.graphhopper.geocoding.client.Configuration;
import com.graphhopper.geocoding.client.Pair;
import com.graphhopper.geocoding.client.ProgressRequestBody;
import com.graphhopper.geocoding.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import com.graphhopper.geocoding.client.model.GeocodingResult;
import com.graphhopper.geocoding.client.model.Error;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeocodingApi {
    private ApiClient apiClient;

    public GeocodingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GeocodingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for geocodeGet */
    private com.squareup.okhttp.Call geocodeGetCall(String key, String q, String locale, Integer limit, Boolean reverse, String point, String provider, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new ApiException("Missing the required parameter 'key' when calling geocodeGet(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/geocode".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (q != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "q", q));
        if (locale != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "locale", locale));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
        if (reverse != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "reverse", reverse));
        if (point != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "point", point));
        if (provider != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "provider", provider));
        if (key != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Execute a Geocoding request
     * This endpoint provides forward and reverse geocoding. For more details, review the official documentation at: https://graphhopper.com/api/1/docs/geocoding/ 
     * @param key Get your key at graphhopper.com (required)
     * @param q If you do forward geocoding, then this would be a textual description of the adress you are looking for. If you do reverse geocoding this would be in lat,lon. (optional)
     * @param locale Display the search results for the specified locale. Currently French (fr), English (en), German (de) and Italian (it) are supported. If the locale wasn&#39;t found the default (en) is used. (optional)
     * @param limit Specify the maximum number of returned results (optional)
     * @param reverse Set to true to do a reverse Geocoding request (optional)
     * @param point The location bias in the format &#39;latitude,longitude&#39; e.g. point&#x3D;45.93272,11.58803 (optional)
     * @param provider Can be either, default, nominatim, opencagedata (optional)
     * @return GeocodingResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GeocodingResult geocodeGet(String key, String q, String locale, Integer limit, Boolean reverse, String point, String provider) throws ApiException {
        ApiResponse<GeocodingResult> resp = geocodeGetWithHttpInfo(key, q, locale, limit, reverse, point, provider);
        return resp.getData();
    }

    /**
     * Execute a Geocoding request
     * This endpoint provides forward and reverse geocoding. For more details, review the official documentation at: https://graphhopper.com/api/1/docs/geocoding/ 
     * @param key Get your key at graphhopper.com (required)
     * @param q If you do forward geocoding, then this would be a textual description of the adress you are looking for. If you do reverse geocoding this would be in lat,lon. (optional)
     * @param locale Display the search results for the specified locale. Currently French (fr), English (en), German (de) and Italian (it) are supported. If the locale wasn&#39;t found the default (en) is used. (optional)
     * @param limit Specify the maximum number of returned results (optional)
     * @param reverse Set to true to do a reverse Geocoding request (optional)
     * @param point The location bias in the format &#39;latitude,longitude&#39; e.g. point&#x3D;45.93272,11.58803 (optional)
     * @param provider Can be either, default, nominatim, opencagedata (optional)
     * @return ApiResponse&lt;GeocodingResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GeocodingResult> geocodeGetWithHttpInfo(String key, String q, String locale, Integer limit, Boolean reverse, String point, String provider) throws ApiException {
        com.squareup.okhttp.Call call = geocodeGetCall(key, q, locale, limit, reverse, point, provider, null, null);
        Type localVarReturnType = new TypeToken<GeocodingResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Execute a Geocoding request (asynchronously)
     * This endpoint provides forward and reverse geocoding. For more details, review the official documentation at: https://graphhopper.com/api/1/docs/geocoding/ 
     * @param key Get your key at graphhopper.com (required)
     * @param q If you do forward geocoding, then this would be a textual description of the adress you are looking for. If you do reverse geocoding this would be in lat,lon. (optional)
     * @param locale Display the search results for the specified locale. Currently French (fr), English (en), German (de) and Italian (it) are supported. If the locale wasn&#39;t found the default (en) is used. (optional)
     * @param limit Specify the maximum number of returned results (optional)
     * @param reverse Set to true to do a reverse Geocoding request (optional)
     * @param point The location bias in the format &#39;latitude,longitude&#39; e.g. point&#x3D;45.93272,11.58803 (optional)
     * @param provider Can be either, default, nominatim, opencagedata (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call geocodeGetAsync(String key, String q, String locale, Integer limit, Boolean reverse, String point, String provider, final ApiCallback<GeocodingResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = geocodeGetCall(key, q, locale, limit, reverse, point, provider, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<GeocodingResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}