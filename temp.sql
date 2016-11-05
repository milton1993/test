CREATE TABLE `t_cpt_price` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  bdsource_code VARCHAR(255) DEFAULT NULL,
  biz VARCHAR(10) NOT NULL DEFAULT 'flight' COMMENT '业务类型：flight/hotel/ticket/vacation/train/group/car',
  price DOUBLE NOT NULL DEFAULT 0 COMMENT '价格',
  is_current BOOLEAN NOT NULL DEFAULT TRUE COMMENT '是否是当前所在季度的价格',
  logday TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '价格记录日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='bdsource cpt合作类型季度价格记录日志表';

CREATE TABLE `t_cpa_price` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  bdsource_code VARCHAR(255) DEFAULT NULL,
  biz VARCHAR(10) NOT NULL DEFAULT 'flight' COMMENT '业务类型：flight/hotel/ticket/vacation/train/group/car',
  booking_start INT(11) NOT NULL DEFAULT 0 COMMENT '起始booking量',
  booking_end INT(11) NOT NULL DEFAULT 0 COMMENT '截止booking量',
  price DOUBLE NOT NULL DEFAULT 0 COMMENT '区间价格',
  is_valid BOOLEAN NOT NULL DEFAULT TRUE COMMENT '是否有效',
  logday TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='bdsource cpa合作类型分段价格记录表';

CREATE TABLE `t_cpc_price` (
  id INT(11) NOT NULL AUTO_INCREMENT,
  bdsource_code VARCHAR(255) DEFAULT NULL,
  biz VARCHAR(10) NOT NULL DEFAULT 'flight' COMMENT '业务类型：flight/hotel/ticket/vacation/train/group/car',
  price DOUBLE NOT NULL DEFAULT 0 COMMENT '价格',
  logday TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='bdsource cpc合作类型价格记录表';