/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.workspace.server.wsplugins.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Lifecycle {

  @JsonProperty("preStop")
  private Handler preStop = new Handler();

  @JsonProperty("postStart")
  private Handler postStart = new Handler();

  /** */
  public Lifecycle preStop(Handler preStop) {
    this.preStop = preStop;
    return this;
  }

  public Handler getPreStop() {
    return preStop;
  }

  public void setPreStop(Handler preStop) {
    this.preStop = preStop;
  }

  /** */
  public Lifecycle postStart(Handler postStart) {
    this.postStart = postStart;
    return this;
  }

  public Handler getPostStart() {
    return postStart;
  }

  public void setPostStart(Handler postStart) {
    this.postStart = postStart;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lifecycle that = (Lifecycle) o;
    return Objects.equals(preStop, that.preStop) && Objects.equals(postStart, that.postStart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(postStart, preStop);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lifecycle {\n");
    sb.append("    postStart: ").append(toIndentedString(postStart)).append("\n");
    sb.append("    preStop: ").append(toIndentedString(preStop)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
