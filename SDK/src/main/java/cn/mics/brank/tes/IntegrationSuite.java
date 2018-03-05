/*
 Copyright IBM Corp. All Rights Reserved.

 SPDX-License-Identifier: Apache-2.0
*/
package cn.mics.brank.tes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith (Suite.class)

@Suite.SuiteClasses({
        End2endIT.class,
//        End2endAndBackAgainIT.class,
//        UpdateChannelIT.class,
//        HFCAClientIT.class
})
public class IntegrationSuite {

}