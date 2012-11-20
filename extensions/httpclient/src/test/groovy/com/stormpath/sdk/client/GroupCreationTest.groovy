/*
 * Copyright 2012 Stormpath, Inc.
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
package com.stormpath.sdk.client

import com.stormpath.sdk.directory.Directory
import com.stormpath.sdk.group.Group

/**
 * Created with IntelliJ IDEA.
 * User: ecrisostomo
 * Date: 11/19/12
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
class GroupCreationTest {

    public static void main(String[] args) {

        DefaultApiKey apiKey = new DefaultApiKey(args[0], args[1]);

        Client client = new Client(apiKey, args[2]);

        String directoryHref = args[3];

        Directory directory = client.getDataStore().getResource(directoryHref, Directory.class);

        Group group = client.getDataStore().instantiate(Group.class);

        group.setDescription("New Group Desc");
        group.setName("New Group");

        directory.createGroup(group);

        if (group.getHref() != null && !group.getHref().isEmpty()) {
            println("Group Created!") ;
        } else {
            throw new Exception("Group was not created!");
        }
    }
}
