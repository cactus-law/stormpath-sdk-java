/*
 * Copyright 2015 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.mail;

import java.util.Map;

/**
 * The {@link ModeledEmailTemplate} is a {@link EmailTemplate} resource which also provides the ability to configure the url where
 * the user will be redirected once he clicks on the link received in the Email.
 *
 * @since 1.0.RC4
 */
public interface ModeledEmailTemplate extends EmailTemplate<ModeledEmailTemplate> {

    /**
     * An {@link Map} where JSON data can be stored. This allows both Stormpath and developers to define variables that can later be
     * replaced when the template is being processed.
     * For example, we currently store the <code>linkBaseUrl</code> key to hold the clickable url that the user will receive
     * inside the reset password or verify account emails.
     *
     * @return the map where custom JSON data (like <code>linkBaseUrl</code>) can be stored.
     * @see #setLinkBaseUrl(String)
     */
    Map<String, String> getDefaultModel();

    /**
     * Convenience method to specify the clickable url that the user will receive inside the email.
     * For example, in the reset password workflow, this url should point to the form where the user can insert his new password.
     * <p/>
     * This is just a convenience method and doing this:
     * <pre>
     *      modeledEmailTemplate.setLinkBaseUrl("http://mycompany.com/templateName.html");
     * </pre>
     * is equivalent to doing:
     * <pre>
     *     modeledEmailTemplate.getDefaultModel().put("linkBaseUrl", "http://mycompany.com/templateName.html");
     * </pre>
     *
     * @param linkBaseUrl clickable url where the user will be taken once he clicks on the URL received in the email.
     * @return this instance for method chaining.
     */
    ModeledEmailTemplate setLinkBaseUrl(String linkBaseUrl);

    /**
     * Return the clickable url that the user will receive inside the email.
     * This is just a convenience method and doing this:
     * <pre>
     *      String linkBaseUrl = modeledEmailTemplate.getLinkBaseUrl();
     * </pre>
     * is equivalent to doing:
     * <pre>
     *      String linkBaseUrl = modeledEmailTemplate.getDefaultModel().get("linkBaseUrl");
     * </pre>
     *
     * @return clickable url where the user will be taken once he clicks on the URL received in the email.
     */
    String getLinkBaseUrl();

}
