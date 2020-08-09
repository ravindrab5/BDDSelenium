package com.ideas.chimps.bddselenium.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModuleAccess {
    private String name;
    private List<SubModule> subModules;

}