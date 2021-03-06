package com.stormpath.sdk.okta;

import com.stormpath.sdk.resource.Resource;

/**
 *
 */
public interface OIDCKey extends Resource {

    String getAlgorithm();
    String getId();
    String getType();
    String getUse();

    String get(String id);

}
