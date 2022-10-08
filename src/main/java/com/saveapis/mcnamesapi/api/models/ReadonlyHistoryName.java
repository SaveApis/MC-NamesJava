package com.saveapis.mcnamesapi.api.models;

import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import com.saveapis.mcnamesapi.models.Name;

public record ReadonlyHistoryName(Name name, ReadonlyCollection<ReadonlyHistNameDateRelation> history) {
}
