package com.mycompany.myproj.main.web.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myproj.entities.MySimpleEntity;
import com.mycompany.myproj.entities.MySimpleEntityRepository;

@Controller
@RequestMapping("/section1")
public class Section1Controller {

  @Autowired
  private MySimpleEntityRepository mySimpleEntityRepo;

  @Transactional
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView displayDefault(Model model) {

    MySimpleEntity entity = new MySimpleEntity(true);
    mySimpleEntityRepo.save(entity);
    
    Iterable<MySimpleEntity> mySimpleEntities = mySimpleEntityRepo.findAll();
    model.addAttribute("mySimpleEntities", mySimpleEntities);

    // Apache Commons ...4.0 templated, but not released yet
    // List<MySimpleEntity> mySimpleEntities =
    // IteratorUtils.toList(entitiesIter.iterator());

    // Guava
    // Lists.newArrayList(myIterator);

    return new ModelAndView("section1/default-section1.ftl");
  }

}
