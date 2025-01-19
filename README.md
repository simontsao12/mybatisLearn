# mybatisLearn

## 專案概述

mybatisLearn 是一個基於 Java 的學習專案，旨在練習 MyBatis 相關的概念與操作。專案按照不同的學習目標進行區分，每個子模組包含相關的測試程式與實現程式碼。

## 專案結構

```
mybatisLearn/
├── pom.xml (父模組)
├── mybatis_01-helloworld/
│   └── pom.xml (子模組 mybatis_01-helloworld)
├── mybatis_02-parameter/
│   └── pom.xml (子模組 mybatis_02-parameter)
├── mybatis_03-resultMap/
│   └── pom.xml (子模組 mybatis_03-resultMap)
├── mybatis_04-dynamicSQL/
│   └── pom.xml (子模組 mybatis_04-dynamicSQL)
├── mybatis_05-cache/
│   └── pom.xml (子模組 mybatis_05-cache)
└── mybatis_06-mbg/
    └── pom.xml (子模組 mybatis_06-mbg)

```

### 1. mybatisLearn


- **目標：** 管理所有子模組共同的依賴與版本。

  
### 2. mybatis_01-helloworld


- **目標：** 於 MyBatis 設定檔設定相關訊息、建立 mapper 介面和映射檔案，並於測試時存取資料庫。

### 3. mybatis_02-parameter


- **目標 1：** 獲取參數的兩種方式 ${} 和 #{}。
- **目標 2：** 獲取不同類型的參數的方式。
- **目標 3：** 使用 @Param 標示參數。
- **目標 4：** 其他查詢、批量刪除、動態設定表名及獲取自增主鍵功能。

### 4. mybatis_03-resultMap


- **目標 1：** 使用 resultMap 處理映射關係。
- **目標 2：** 使用全域設定處理資料表欄位名與屬性名不一致的情況。
- **目標 3：** 處理多對一映射關係。
- **目標 4：** 了解延遲加載。
- **目標 5：** 處理一對多映射關係。

### 5. mybatis_04-dynamicSQL


- **目標 1：** 了解動態 SQL。
- **目標 2：** 動態 SQL 不同標籤的使用，如 if、where、trim、choose、when、otherwise、foreach 及 sql。

### 6. mybatis_05-cache


- **目標 1：** 了解一級快取和失效的情況。
- **目標 2：** 了解二級快取和相關配置。
- **目標 3：** 使用第三方快取進行整合。

### 7. mybatis_06-mbg


- **目標 1：** 了解 MyBatis 的逆向工程。
- **目標 2：** 使用分頁擴充功能。

## 設定檔

- `mybatis-config.xml`： MyBatis 設定檔。
- `log4j.xml`： 日誌設定檔。
- `jdbc.properties`： 通用 JDBC 配置。

## 需求

- JDK 版本： 11
- MySQL 版本： 8
- MyBatis 版本： 3.5.7
- Maven 版本： 3.9.9

## 使用方式

1. **安裝依賴：** 確保已安裝 JDK 和相關資料庫，並設定相關依賴。
2. **配置資料庫：** 修改 `jdbc.properties` 等設定檔中的參數，以匹配您的資料庫設定。
3. **導入專案：** 使用 IDE（如 IntelliJ IDEA 或 Eclipse）導入專案。
4. **執行測試：** 選擇並運行對應的測試類進行學習。

## 注意事項

- 確保資料庫服務已啟動，並正確設定用戶名與密碼。
- 在執行涉及資源的操作時，請檢查相關文件路徑是否有效。

## 主要學習資源

- 【尚硅谷】2022版MyBatis教學（細緻全面，快速上手）。
- 【尚硅谷】SSM框架全套教程，MyBatis+Spring+SpringMVC+SSM整合一套通關。

## 貢獻者

此專案僅為學習用途。