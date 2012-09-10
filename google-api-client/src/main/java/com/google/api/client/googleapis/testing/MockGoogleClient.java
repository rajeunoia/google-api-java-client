/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.client.googleapis.testing;

import com.google.api.client.googleapis.AbstractGoogleClient;
import com.google.api.client.googleapis.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.subscriptions.SubscriptionManager;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;

/**
 * Thread-safe mock Google client.
 *
 * @since 1.12
 * @author Yaniv Inbar
 */
public class MockGoogleClient extends AbstractGoogleClient {

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param objectParser object parser
   */
  public MockGoogleClient(HttpTransport transport, HttpRequestInitializer httpRequestInitializer,
      String rootUrl, String servicePath, ObjectParser objectParser) {
    super(transport, httpRequestInitializer, rootUrl, servicePath, objectParser);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param objectParser object parser or {@code null} for none
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param subscriptionManager subscription manager
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  public MockGoogleClient(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      ObjectParser objectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      SubscriptionManager subscriptionManager,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        objectParser,
        googleClientRequestInitializer,
        applicationName,
        subscriptionManager,
        suppressPatternChecks);
  }

  /**
   * Builder for {@link MockGoogleClient}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   */
  public static class Builder extends AbstractGoogleClient.Builder {

    /**
     * @param transport The transport to use for requests
     * @param rootUrl root URL of the service. Must end with a "/"
     * @param servicePath service path
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     */
    public Builder(HttpTransport transport, String rootUrl, String servicePath,
        ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
      super(transport, rootUrl, servicePath, objectParser, httpRequestInitializer);
    }

    @Override
    public MockGoogleClient build() {
      return new MockGoogleClient(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSubscriptionManager(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSubscriptionManager(SubscriptionManager subscriptionManager) {
      return (Builder) super.setSubscriptionManager(subscriptionManager);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }
  }
}
