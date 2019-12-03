/**
 * 
 */
package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

/**
 * @author Pratheba
 *
 */
public class MenuItemDaoSqlImpl implements MenuItemDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListAdmin()
	 */
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
				Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select me_id,me_name,me_active,me_date_of_launch,me_price,me_category,me_free_delivery from menu_item");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt("me_id");
					String name = resultSet.getString("me_name");
					Date dateOfLaunch = resultSet.getDate("me_date_of_launch");
					String active = resultSet.getString("me_active");
					float price = resultSet.getFloat("me_price");
					String category = resultSet.getString("me_category");
					String freeDelivery = resultSet
							.getString("me_free_delivery");
					if (freeDelivery != null && freeDelivery.equals("Yes")) {
						freeDeliveryFlag = true;
					} else {
						freeDeliveryFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MenuItem menuItem = new MenuItem(id, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					
					System.out.println(menuItem);
					menuItemList.add(menuItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuItemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListCustomer()
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select * from menu_item where me_date_of_launch <= now() and me_active='Yes'");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					Date dateOfLaunch = resultSet.getDate(5);
					String active = resultSet.getString(4);
					float price = resultSet.getFloat(3);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (freeDelivery != null && freeDelivery.equals("Yes")) {
						freeDeliveryFlag = true;
					} else {
						freeDeliveryFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MenuItem menuItem = new MenuItem(id, name, price,
							activeFlag, dateOfLaunch, category,
							freeDeliveryFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(menuItem);
					menuItemList.add(menuItem);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return menuItemList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum
	 * .model.MenuItem)
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		String sql = "update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_free_delivery=?,me_category=? where me_id=?";
		try {
			if (conn != null) {
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
				preparedStatement.setString(1, menuItem.getName());
				preparedStatement.setFloat(2, menuItem.getPrice());
				if (menuItem.isActive()) {
					preparedStatement.setString(3, "Yes");
				} else {
					preparedStatement.setString(3, "No");
				}
				preparedStatement.setDate(4, new java.sql.Date(menuItem
						.getDateOfLaunch().getTime()));

				if (menuItem.isFreeDelivery()) {
					preparedStatement.setString(5, "Yes");
				} else {
					preparedStatement.setString(5, "No");
				}
				preparedStatement.setString(6, menuItem.getCategory());
				preparedStatement.setLong(7, menuItem.getId());
				preparedStatement.executeUpdate();

			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MenuItem menuItem = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from menu_item where me_id=?");
				preparedStatement.setLong(1, menuItemId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, freeDeliveryFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String name = resultSet.getString(2);
					float price = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String category = resultSet.getString(6);
					String freeDelivery = resultSet.getString(7);
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (freeDelivery != null && freeDelivery.equals("Yes"))
						freeDeliveryFlag = true;
					else
						freeDeliveryFlag = false;
					menuItem = new MenuItem(menuItemId, name, price,
							activeFlag, date_of_launch, category,
							freeDeliveryFlag);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return menuItem;

	}

}
