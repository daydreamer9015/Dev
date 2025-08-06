import logo from './logo.svg';
import './App.css';
import Dog from './Dog'
import Cat from'./Cat'
import Header from './components/Header';
import Slider from './components/Slider';
import Main from './components/Main';
import Footer from './components/Footer';
import Footer2 from './components/Footer2';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <Slider style={{width:"100%", color:"white", height:"200px", background:"gold"}}></Slider>
      <Main></Main>
      <Footer></Footer>
      <Footer2></Footer2>
    </div>
  );
}

export default App;
