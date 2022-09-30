package application_baepo.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	private static SqlSessionFactory instance;
	
	private MybatisManager() {
		//super();
	}

	public static SqlSessionFactory getInstance() {
		Reader reader = null;
		try {
			String resource = "application_baepo/config/mybatisConfig.xml";
			reader = Resources.getResourceAsReader(resource);
			instance = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러..");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}//try-catch
			}//if
		}//try-catch-finally
		return instance;
	}//getInstance
}//MybatisManager
