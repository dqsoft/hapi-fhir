package ca.uhn.fhir.jpa.subscription.channel.subscription;

/*-
 * #%L
 * HAPI FHIR Subscription Server
 * %%
 * Copyright (C) 2014 - 2020 University Health Network
 * %%
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
 * #L%
 */

import ca.uhn.fhir.jpa.subscription.model.CanonicalSubscription;
import org.springframework.stereotype.Service;

public class SubscriptionDeliveryChannelNamer implements ISubscriptionDeliveryChannelNamer {
	@Override
	public String nameFromSubscription(CanonicalSubscription theCanonicalSubscription) {
		String channelType = theCanonicalSubscription.getChannelType().toCode().toLowerCase();
		String subscriptionId = theCanonicalSubscription.getIdPart();
		return "subscription-delivery-" +
			channelType +
			"-" +
			subscriptionId;
	}
}
