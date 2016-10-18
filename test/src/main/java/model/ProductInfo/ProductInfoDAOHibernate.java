package model.ProductInfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import misc.HibernateUtil;

public class ProductInfoDAOHibernate implements ProductInfoDAO {

	// 測試程式
	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			// 查詢
			// ProductInfoDAOHibernate dao = new ProductInfoDAOHibernate(session);
			// ProductInfoBean bean = dao.select(1);
			// System.out.println("bean="+bean);
			// 新增
			// ProductInfoDAOHibernate insert = new ProductInfoDAOHibernate(session);
			// ProductInfoBean bean = new ProductInfoBean();
			// bean.setProdClass("玩具");
			// bean.setProdName("籃球");
			// bean.setProdPrice(100);
			// bean.setInventory(2);
			// bean.setFoodCheck(0);
			// insert.insert(bean);
			// System.out.println("insert=" + insert);
			//
			// 修改
			// ProductInfoDAOHibernate update = new ProductInfoDAOHibernate(session);
			// update.update(3,"交通類","腳踏車",200000,1,0,"".getBytes());
			// 刪除
			// ProductInfoDAOHibernate dao = new ProductInfoDAOHibernate(session);
			// dao.delete(4);
			// 查詢全部
			ProductInfoDAOHibernate selectall = new ProductInfoDAOHibernate(session);
			List<ProductInfoBean> bean = selectall.selectall();
			System.out.println(bean);
			//

			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
	}

	// session-----------------------------------------------
	private Session session = null;

	public ProductInfoDAOHibernate(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	// method---------------------------------------------

	public ProductInfoBean select(int ProdCode) {

		return (ProductInfoBean) this.getSession().get(ProductInfoBean.class,ProdCode);
	}

	public ProductInfoBean update(int ProdCode, String ProdClass, String ProdName, float ProdPrice, int Inventory, boolean FoodCheck, byte[] ProdImage) {

		ProductInfoBean result = (ProductInfoBean) this.getSession().get(ProductInfoBean.class,ProdCode);
		if (result != null) {
			result.setProdCode(ProdCode);
			result.setProdClass(ProdClass);
			result.setProdName(ProdName);
			result.setProdPrice(ProdPrice);
			result.setInventory(Inventory);
			result.setFoodCheck(FoodCheck);
			result.setProdImage(ProdImage);
		}
		return result;
	}
	
	public ProductInfoBean insert(ProductInfoBean bean) {
		ProductInfoBean temp = (ProductInfoBean) this.getSession().get(ProductInfoBean.class,bean.getProdCode());
		if (temp == null) {
			this.getSession().save(bean);
		}

		return null;
	}

	public boolean delete(int ProdCode) {
		ProductInfoBean bean = (ProductInfoBean) this.getSession().get(ProductInfoBean.class,ProdCode);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	public List<ProductInfoBean> selectall() {
		Query query = this.getSession().createQuery("from ProductInfoBean");
		return (List<ProductInfoBean>) query.list();
	}


}
