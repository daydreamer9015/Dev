import React, {useState} from 'react';
import './App.css';

function App() {
  
  // 장바구니 선언
  // cart: 현재 장바구니 상태를 저장하는 배열
  // setCart: cart를 업데이트하는 함수
  const [cart, setCart] = useState([
    {id: 1, name: '노트북', price: 1500000},
    {id: 2, name: '마우스', price: 50000}
  ])


  return (
    <div className="App">      
      {/*현재 장바구니 상태 표시*/}
        <h1>🛒장바구니 앱</h1>
        <div className='cart-info'>
          <h2>현재 장바구니</h2>
          <p>상품 개수: {cart.length}개</p>
        </div>

        {/*장바구니 아이템 목록*/}
        <div className='cart-items'>
          {
            cart.map(item => (
              <div key={item.id} className='cart-item'>
                <span>{item.name}</span>
                <span>{item.price.toLocaleString()}원</span>
              </div>
            ))          
          }
        </div>
    </div>
  );
}

export default App;
