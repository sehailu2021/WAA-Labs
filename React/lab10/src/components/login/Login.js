import { useRef } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";


const Login = (props) => {


    const newForm = useRef();
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const loginHandler = async (e) => {
        e.preventDefault();
        const form = newForm.current;
        const userCredentials = { email: form['email'].value, password: form['password'].value };
        const result = await dispatch(doLogin(userCredentials));
        dispatch(authActions.loginSuccessful());
        Cookies.set('email', result.payload);
        navigate('/dashbord')
    }
    const doLogin = createAsyncThunk('login', async (userCredentials) => {
        const res = axios.get('http://localhost:8080/api/v1/auth', userCredentials);
        return res.data;

    });


    return (
        <div >
            <form ref={newForm} onSubmit={loginHandler} >
                <div>
                    <label htmlFor="email">Email</label>
                    <input type="text" id="email"/>
                </div>
                <div>
                    <label htmlFor="password">Password</label>
                    <input type="password" id = 'password' />
                </div>
                <button>Login</button>
            </form>
        </div>
    )

}
export default Login;