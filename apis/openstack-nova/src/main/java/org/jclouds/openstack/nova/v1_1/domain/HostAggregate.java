/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.openstack.nova.v1_1.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.annotations.SerializedName;

/**
 * Aggregates can be manipulated using the Aggregate Extension to Nova (alias "OS-AGGREGATES")
 *
 * @see org.jclouds.openstack.nova.v1_1.extensions.HostAggregateClient
 */
public class HostAggregate {

   public static Builder<?> builder() {
      return new ConcreteBuilder();
   }

   public Builder<?> toBuilder() {
      return new ConcreteBuilder().fromAggregate(this);
   }

   public static abstract class Builder<T extends Builder<T>> {
      protected abstract T self();

      private String id;
      private String name;
      private String availabilityZone;
      private Set<String> hosts = ImmutableSet.of();
      private String state;
      private Date created = new Date();
      private Date updated;
      private Map<String, String> metadata = ImmutableMap.of();

      /**
       * @see HostAggregate#getId()
       */
      public T id(String id) {
         this.id = id;
         return self();
      }

      /**
       * @see HostAggregate#getName()
       */
      public T name(String name) {
         this.name = name;
         return self();
      }

      /**
       * @see HostAggregate#getAvailabilityZone()
       */
      public T availabilityZone(String availabilityZone) {
         this.availabilityZone = availabilityZone;
         return self();
      }

      /**
       * @see HostAggregate#getHosts()
       */
      public T hosts(String... hosts) {
         return hosts(ImmutableSet.copyOf(hosts));
      }
      
      /**
       * @see HostAggregate#getHosts()
       */
      public T hosts(Set<String> hosts) {
         this.hosts = hosts;
         return self();
      }

      /**
       * @see HostAggregate#getState()
       */
      public T state(String state) {
         this.state = state;
         return self();
      }

      /**
       * @see HostAggregate#getCreated()
       */
      public T created(Date created) {
         this.created = created;
         return self();
      }

      /**
       * @see HostAggregate#getUpdated()
       */
      public T updated(Date updated) {
         this.updated = updated;
         return self();
      }

      /**
       * @see HostAggregate#getMetadata()
       */
      public T metadata(Map<String, String> metadata) {
         this.metadata = metadata;
         return self();
      }

      public HostAggregate build() {
         return new HostAggregate(this);
      }

      public T fromAggregate(HostAggregate in) {
         return this
               .id(in.getId())
               .name(in.getName())
               .availabilityZone(in.getAvailabilityZone())
               .hosts(in.getHosts())
               .state(in.getState())
               .created(in.getCreated())
               .updated(in.getUpdated().orNull())
               .metadata(in.getMetadata());
      }

   }

   private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
      @Override
      protected ConcreteBuilder self() {
         return this;
      }
   }

   private final String id;
   private final String name;
   @SerializedName(value = "availability_zone")
   private final String availabilityZone;
   private final Set<String> hosts;
   @SerializedName(value = "operational_state")
   private final String state;
   @SerializedName(value = "created_at")
   private final Date created;
   @SerializedName(value = "updated_at")
   private final Optional<Date> updated;
   private final Map<String, String> metadata;

   protected HostAggregate(Builder<?> builder) {
      this.id = checkNotNull(builder.id, "id");
      this.name = checkNotNull(builder.name, "name");
      this.availabilityZone = checkNotNull(builder.availabilityZone, "availabilityZone");
      this.hosts = ImmutableSet.copyOf(checkNotNull(builder.hosts, "hosts"));
      this.state = checkNotNull(builder.state, "state");
      this.created = checkNotNull(builder.created, "created");
      this.updated = Optional.fromNullable(builder.updated);
      this.metadata = ImmutableMap.copyOf(checkNotNull(builder.metadata, "metadata"));
   }

   // Ensure GSON parsed objects don't have null collections or optionals
   protected HostAggregate() {
      this.id = null;
      this.name = null;
      this.availabilityZone = null;
      this.hosts = ImmutableSet.of();
      this.state = null;
      this.created = null;
      this.updated = Optional.absent();
      this.metadata = ImmutableMap.of();
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   /**
    * note: an "Availability Zone" is different from a Nova "Zone"
    *
    * @return the availability zone this aggregate is in
    */
   public String getAvailabilityZone() {
      return this.availabilityZone;
   }

   public Set<String> getHosts() {
      return Collections.unmodifiableSet(this.hosts);
   }

   public String getState() {
      return this.state;
   }

   public Date getCreated() {
      return this.created;
   }

   public Optional<Date> getUpdated() {
      return this.updated;
   }

   public Map<String, String> getMetadata() {
      return this.metadata;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(id, name, availabilityZone, hosts, state, created, updated, metadata);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      HostAggregate that = HostAggregate.class.cast(obj);
      return Objects.equal(this.id, that.id)
            && Objects.equal(this.name, that.name)
            && Objects.equal(this.availabilityZone, that.availabilityZone)
            && Objects.equal(this.hosts, that.hosts)
            && Objects.equal(this.state, that.state)
            && Objects.equal(this.created, that.created)
            && Objects.equal(this.updated, that.updated)
            && Objects.equal(this.metadata, that.metadata)
            ;
   }

   protected ToStringHelper string() {
      return Objects.toStringHelper("")
            .add("id", id)
            .add("name", name)
            .add("availabilityZone", availabilityZone)
            .add("hosts", hosts)
            .add("state", state)
            .add("created", created)
            .add("updated", updated)
            .add("metadata", metadata);
   }

   @Override
   public String toString() {
      return string().toString();
   }

}