# JDBC Notes

## Overview

JDBC (Java Database Connectivity) is the standard Java API for connecting to relational databases. It provides a set of interfaces and classes for sending SQL statements and processing results in a database-independent way.

## Key Interfaces and Classes

- **`Driver` (interface)**: Low-level interface implemented by database vendors to handle connection requests.
- **`DriverManager` (class)**: Manages registered `Driver` implementations and establishes connections via `getConnection()`.
- **`Connection` (interface)**: Represents a connection to a specific database. Methods include `prepareStatement()`, `createStatement()`, `commit()`, `rollback()`, and `close()`.
- **`Statement` (interface)**: For executing simple SQL statements. Methods include `executeQuery()`, `executeUpdate()`, and `execute()`.
- **`PreparedStatement` (interface)**: A precompiled SQL statement with parameter placeholders; safer and often faster for repeated queries.
- **`CallableStatement` (interface)**: Used to call stored procedures.
- **`ResultSet` (interface)**: Represents the result of a `SELECT` query. Use `next()` to iterate rows and getters like `getString()`, `getInt()` to read columns.
- **`ResultSetMetaData` (interface)**: Metadata about columns in a `ResultSet` (column count, names, types).
- **`DatabaseMetaData` (interface)**: Metadata about the database (tables, supported features, driver info).

## Typical JDBC Connection Flow

1. Ensure the JDBC driver (Connector/J for MySQL) is on the application's classpath (jar or dependency).
2. Optionally load the driver class (modern drivers auto-register): `Class.forName("com.mysql.cj.jdbc.Driver");`.
3. Build the JDBC URL: `jdbc:mysql://<host>:<port>/<database>?<params>`.
4. Obtain a `Connection` via `DriverManager.getConnection(url, user, password)`.
5. Create a `PreparedStatement` or `Statement` and execute SQL.
6. Process the `ResultSet`.
7. Close `ResultSet`, `Statement` and `Connection` (use try-with-resources).

## MySQL: Prerequisites

- Java (JDK) installed.
- MySQL Server running and reachable.
- MySQL user with proper privileges for the target database.
- MySQL Connector/J (Connector library). Add as:

Maven dependency:

```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.0.34</version>
</dependency>
```

Or download `mysql-connector-java-8.x.x.jar` and add it to the classpath.

## Step-by-step: Connect to MySQL (detailed)

1) Create database and user (MySQL shell):

```sql
-- login as root or admin
CREATE DATABASE sampledb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 's3cretP@ss';
GRANT ALL PRIVILEGES ON sampledb.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
```

2) Add the Connector/J dependency or jar to your project classpath (see Maven snippet above).

3) Construct the JDBC URL. Recommended parameters:

```
jdbc:mysql://<host>:<port>/<dbname>?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
```

Example:

```
jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
```

Notes on params:
- `serverTimezone=UTC` — helps avoid timezone exceptions.
- `useSSL=false` — disable if you don't use SSL; for production use proper SSL.
- `allowPublicKeyRetrieval=true` — sometimes needed when using caching_sha2_password and no SSL.

4) Minimal Java example (try-with-resources, `PreparedStatement`):

```java
import java.sql.*;

public class JdbcExample {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "appuser";
		String pass = "s3cretP@ss";

		String sql = "SELECT id, name, email FROM users WHERE status = ?";

		try (Connection conn = DriverManager.getConnection(url, user, pass);
			 PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, "active");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					System.out.printf("%d: %s <%s>\n", id, name, email);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
```

5) (Optional) Explicit driver loading — not required for modern drivers but harmless:

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

6) Connection pooling recommendation

- For production, use a connection pool (HikariCP, Apache DBCP, or C3P0). Example dependency for HikariCP:

```xml
<dependency>
  <groupId>com.zaxxer</groupId>
  <artifactId>HikariCP</artifactId>
  <version>6.0.2</version>
</dependency>
```

7) Common troubleshooting

- "No suitable driver" — Connector/J not on classpath or URL malformed.
- "Communications link failure" — MySQL server not reachable (host/port/firewall) or server down.
- "Access denied for user" — wrong credentials or host mismatch (user@host). Ensure the user is created for correct host (e.g., 'appuser'@'%').
- Timezone/SSL exceptions — adjust `serverTimezone` and `useSSL` parameters.

8) Security and best practices

- Do not hard-code credentials — use environment variables or a secrets manager.
- Use least-privilege database users.
- Use SSL/TLS for network encryption in production.
- Prefer `PreparedStatement` to avoid SQL injection.

## Example: Maven project quick-run steps

1. Add `mysql-connector-j` to `pom.xml` (see snippet above).
2. Build with `mvn package`.
3. Run the class:

```bash
mvn exec:java -Dexec.mainClass="com.example.JdbcExample"
```

## Quick checklist before running your app

- MySQL server running and database exists.
- Connector/J on classpath (or declared dependency).
- Correct JDBC URL, user and password.
- Proper privileges for the user.
- Firewall/port (default 3306) open if connecting remotely.

---

If you want, I can also:
- Add a ready-to-run sample `pom.xml` and `JdbcExample` source under a small demo project.
- Show how to configure a basic HikariCP pool.

## Quick: Execute queries and modify data (minimal steps)

1. Connect

```java
String url = "jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC";
try (Connection conn = DriverManager.getConnection(url, user, pass)) {
	// use conn
}
```

2. SELECT (read data)

```java
String sql = "SELECT id, name FROM users WHERE status = ?";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
	ps.setString(1, "active");
	try (ResultSet rs = ps.executeQuery()) {
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
		}
	}
}
```

3. INSERT (change data, get generated key)

```java
String insert = "INSERT INTO users(name,email) VALUES(?,?)";
try (PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
	ps.setString(1, "Bob");
	ps.setString(2, "bob@example.com");
	int rows = ps.executeUpdate();
	try (ResultSet keys = ps.getGeneratedKeys()) {
		if (keys.next()) System.out.println("new id=" + keys.getLong(1));
	}
}
```

4. UPDATE / DELETE (change data)

```java
String update = "UPDATE users SET status = ? WHERE id = ?";
try (PreparedStatement ps = conn.prepareStatement(update)) {
	ps.setString(1, "inactive");
	ps.setInt(2, 42);
	int affected = ps.executeUpdate();
}
```

5. Transactions (multiple statements)

```java
try {
	conn.setAutoCommit(false);
	// run statements
	conn.commit();
} catch (SQLException e) {
	conn.rollback();
}
```

6. Best practices (short)
- Use `PreparedStatement` to avoid SQL injection.
- Use try-with-resources to auto-close `ResultSet`, `Statement`, and `Connection`.
- Use connection pooling (DataSource/HikariCP) in production.


