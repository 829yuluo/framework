//package indi.yuluo.springboot.config;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.FileOutConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.TemplateConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class MybatisPlusGenerator {
//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append(tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    /**
//     *
//     * @param author 生成代码的作者
//     * @param dbIP 数据库Ip
//     * @param dbPort 数据库的端口号
//     * @param dbName 数据库的名字
//     * @param dbUser 数据库的账号
//     * @param dbPwd 数据库的密码
//     * @param projectPath 代码的绝对根目录
//     * @param basePackageName 代码的包名目录
//     * @param moduleName 表隶属的模块名
//     * @param tableNames 表的名字，可以多表
//     */
//    public static void generate(String author, String dbIP, String dbPort, String dbName, String dbUser, String dbPwd, String projectPath, String basePackageName, String moduleName, String... tableNames) {
//        // 自定义需要填充的字段
//        List<TableFill> tableFillList = new ArrayList<TableFill>();
//        // 每张表都有一个创建时间、修改时间
//        TableFill createField = new TableFill("create_time", FieldFill.INSERT);
//        TableFill modifiedField = new TableFill("update_time", FieldFill.INSERT_UPDATE);
//        tableFillList.add(createField);
//        tableFillList.add(modifiedField);
//
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 选择引擎需要指定如下加，注意 pom 依赖必须有！
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor(author);
//        gc.setOpen(false);
//        gc.setActiveRecord(true);
//        gc.setSwagger2(true);
///*
//        gc.setMapperName("%sDao");// 设置Mapper接口的名字
//*/
//        gc.setFileOverride(true);// 重新生成的时候，会覆盖之前的
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://" + dbIP + ":" + dbPort + "/" + dbName + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername(dbUser);
//        dsc.setPassword(dbPwd);
//        mpg.setDataSource(dsc);
//
//        // 模块配置
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(moduleName);
//        pc.setParent(basePackageName);
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//            }
//        };
//        List<FileOutConfig> focList = new ArrayList<>();
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
///*
//        strategy.setSuperEntityClass("com.baomidou.mybatisplus.samples.generator.common.BaseEntity");
//*/
//        strategy.setEntityLombokModel(true);
//        strategy.setEntityBuilderModel(true);
//        strategy.setTableFillList(tableFillList);
///*
//        strategy.setSuperControllerClass("com.baomidou.mybatisplus.samples.generator.common.BaseController");
//*/
//        strategy.setInclude(tableNames);
//        strategy.setEntityTableFieldAnnotationEnable(true);
///*
//        strategy.setSuperEntityColumns("id");
//*/
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
///*
//        mpg.getPackageInfo().setMapper("dao");
//*/
//        mpg.execute();
//    }
//
//    public static void main(String[] args) {
//        String author = "jxl";
//        String dbIP = "127.0.0.1";
//        String dbPort = "3306";
//        String dbName = "test";
//        String dbUser = "test";
//        String dbPwd = "test";
//        String projectPath = System.getProperty("user.dir");
//        String packageName = "com.framework.generator";
//        String moduleName = "user";
//        generate(author, dbIP, dbPort, dbName, dbUser, dbPwd, projectPath, packageName, moduleName, "user", "class", "job");
//    }
//}
//
