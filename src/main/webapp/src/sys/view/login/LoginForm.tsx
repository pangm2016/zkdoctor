import React, {Component} from "react";
import {Button, Form, Icon, Input, Row} from "antd";
import styles from "./login.less";
import {FormComponentProps} from "antd/lib/form/Form";
import config from "../../../common/config.js";

export interface ModalProps extends FormComponentProps{
    onOk: any;
    loading:boolean;
}

class LoginForm extends Component<ModalProps, any> {
    render() {
        let thisV = this;
        function handleOk () {
            thisV.props.form.validateFieldsAndScroll((errors, values) => {
                if (errors) {
                    return
                }
                thisV.props.onOk(values.userName, values.password);
            })
        }

        return (
            <div className={styles.form}>
                <div className={styles.logo} >
                    <img src={`${config.assertPrefix}${config.logoSrc}`}/>
                </div>
                <form>
                    <Form.Item hasFeedback>
                        {thisV.props.form.getFieldDecorator('userName', {
                            rules: [
                                {
                                    required: true,
                                    message: '请填写邮箱帐户'
                                }
                            ]
                        })(<Input addonBefore={<Icon type='user'/>} size='large' onPressEnter={handleOk} placeholder='用户名'/>)}
                    </Form.Item>
                    <Form.Item hasFeedback>
                        {thisV.props.form.getFieldDecorator('password', {
                            rules: [
                                {
                                    required: true,
                                    message: '请填写密码'
                                }
                            ]
                        })(<Input addonBefore={<Icon type="lock" />} size='large' type='password' onPressEnter={handleOk} placeholder='密码'/>)}
                    </Form.Item>
                    <Row>
                        <Button type='primary' size='large' onClick={handleOk} loading={this.props.loading}>
                            登录
                        </Button>
                    </Row>
                </form>
            </div>
        );
    }
}

export default Form.create()(LoginForm);