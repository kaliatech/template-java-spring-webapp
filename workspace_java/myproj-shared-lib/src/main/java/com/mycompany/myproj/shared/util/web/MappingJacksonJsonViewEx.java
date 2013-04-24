package com.mycompany.myproj.shared.util.web;

import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 * This class will make sure that if there is a single object to transform to JSON, it won't be rendered inside a map.
 */
public class MappingJacksonJsonViewEx extends MappingJacksonJsonView {

  @Override
  protected Object filterModel(Map<String, Object> model) {
    Object result = super.filterModel(model);
    if (!(result instanceof Map)) {
      return result;
    }

    @SuppressWarnings("rawtypes")
    Map map = (Map) result;

    if (map.size() == 1) {
      return map.values().toArray()[0];
    }
    return map;
  }
}
