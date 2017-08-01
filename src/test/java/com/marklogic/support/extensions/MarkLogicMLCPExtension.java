package com.marklogic.support.extensions;

import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MarkLogicMLCPExtension implements BeforeAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback, Extension {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        LOG.debug(String.format("%s (AFTER ALL TESTS)", MethodHandles.lookup().lookupClass().getSimpleName()));
        LOG.info("■ MarkLogic Content Pump (AFTER ALL TESTS) ■");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        LOG.debug(String.format("%s (AFTER TEST)", MethodHandles.lookup().lookupClass().getSimpleName()));
        LOG.info(String.format(" ■■ MarkLogic Content Pump (AFTER) ■ %s ■■", context.getDisplayName()));
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        LOG.debug(String.format("%s (BEFORE ALL TESTS)", MethodHandles.lookup().lookupClass().getSimpleName()));
        LOG.info("■ MarkLogic Content Pump (BEFORE ALL TESTS) ■");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        LOG.debug(String.format("%s (BEFORE TEST)", MethodHandles.lookup().lookupClass().getSimpleName()));
        LOG.info(String.format(" ■■ MarkLogic Content Pump (BEFORE) ■ %s ■■", context.getDisplayName()));
    }
}
