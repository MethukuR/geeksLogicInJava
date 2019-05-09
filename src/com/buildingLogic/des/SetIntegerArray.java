package com.buildingLogic.des;

import java.util.HashSet;
import java.util.List;

public class SetIntegerArray extends HashSet {
  List<Integer> permutation;

  public SetIntegerArray(List<Integer> permutation) {
    super();
    this.permutation = permutation;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((permutation == null) ? 0 : permutation.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SetIntegerArray other = (SetIntegerArray) obj;
    if (permutation == null) {
      if (other.permutation != null)
        return false;
    } else if (!permutation.equals(other.permutation))
      return false;
    return true;
  }
  
  
  
}
